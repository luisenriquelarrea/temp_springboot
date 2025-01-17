package com.artplusplus.contpp.utils;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

public class Funciones {
    public static String currentTimestamp(){
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the current date and time
        return now.format(formatter);
    }

    public static byte[] getPDFJasperReport(JasperPrint jasperPrint) throws JRException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public static byte[] getXLSJasperReport(JasperPrint jasperPrint) throws JRException{
        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setDetectCellType(true);
        configuration.setWhitePageBackground(false);
        configuration.setFontSizeFixEnabled(false);
        
        // No spaces between rows and columns 
        configuration.setRemoveEmptySpaceBetweenRows(true); 
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        
        // If you want to name sheets then uncomment this line
        // configuration.setSheetNames(new String[] { "Data" });
        final JRXlsExporter exporter = new JRXlsExporter();
        exporter.setConfiguration(configuration);
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(baos);
        exporter.setExporterOutput(exporterOutput);
        exporter.exportReport();
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public static String removeHexCharacters(String text) {
        // strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");
    
        // erases all the ASCII control characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
        
        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");
        
        return text;
    }

    public static String toTimestamp(String fecha){
        fecha = fecha.replace("T", " ");
        if(fecha.length() == 10)
            fecha += " 00:00:00";
        if(fecha.length() == 16) 
            fecha += ":00";
        return fecha;
    }
}