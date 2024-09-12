package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRSaver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStream;

@Service
public class JasperReportsService {
    @Autowired
    private DataSource dataSource;

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;

    public void generateReport(String template, Map<String, Object> parameters){
        try{
            compileReport(template);
            jasperPrint = JasperFillManager.fillReport(jasperReport, 
                parameters, dataSource.getConnection());
        } catch (JRException | SQLException ex) {
            Logger.getLogger(JasperReportsService.class.getName()).log(Level.SEVERE, 
                null, ex);
        }
    }

    public void compileReport(String template){
        try{
            InputStream reportStream 
                = getClass().getResourceAsStream("/jaspertemplates/"+template);
            jasperReport = JasperCompileManager.compileReport(reportStream);
            JRSaver.saveObject(jasperReport, template.replace(".jrxml", ".jasper"));
        }catch (JRException ex){
            Logger.getLogger(JasperReportsService.class.getName()).log(Level.SEVERE, 
                null, ex);
        }
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }
}