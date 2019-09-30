package com.ogoma.vue_starter.vue_starter.utils.reports;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;

@Component
@Qualifier("JasperReportGenerator")
public class JasperReportGenerator implements ReportGenerator {
    @Autowired
    private DataSource dataSource;

    public ByteArrayOutputStream generatePdfReport(String reportPath, HashMap reportParams) throws Exception {
        reportParams = reportParams == null ? new HashMap<String, Object>() : reportParams;
        Connection connection = dataSource.getConnection();
        ClassPathResource reportResource = new ClassPathResource(reportPath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportResource.getInputStream(), reportParams,connection);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        return outputStream;


    }

    public ByteArrayOutputStream generatePdfReport(String reportPath, HashMap reportParams, Collection dataSource)
            throws Exception {
        reportParams = reportParams == null ? new HashMap<String, Object>() : reportParams;
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(dataSource,true);
        ClassPathResource reportResource = new ClassPathResource(reportPath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportResource.getInputStream(), reportParams, itemsJRBean);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        return outputStream;
    }
}
