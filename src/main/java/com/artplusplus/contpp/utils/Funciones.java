package com.artplusplus.contpp.utils;

import java.io.ByteArrayOutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Funciones {
    public static byte[] getPDFJasperReport(JasperPrint jasperPrint) throws JRException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
        byte[] pdfBytes = baos.toByteArray();
        return pdfBytes;
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