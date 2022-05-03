package com.ogoma.hr_core.utils.reports;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;

public interface ReportGenerator {

    public ByteArrayOutputStream generatePdfReport(String reportPath, HashMap reportParams) throws Exception;
    public ByteArrayOutputStream generatePdfReport(String reportPath, HashMap reportParams, Collection dataSource) throws Exception;
}
