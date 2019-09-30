package com.ogoma.vue_starter.vue_starter.utils.reports;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;

public interface ReportGenerator {

    public ByteArrayOutputStream generatePdfReport(String reportPath, HashMap reportParams) throws Exception;
    public ByteArrayOutputStream generatePdfReport(String reportPath, HashMap reportParams, Collection dataSource) throws Exception;
}
