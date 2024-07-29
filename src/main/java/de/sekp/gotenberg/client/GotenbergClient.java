package de.sekp.gotenberg.client;

import de.sekp.gotenberg.client.dto.GotenbergFile;

public interface GotenbergClient {

    /**
     * Transforms an Office File to a PDF File
     * @param officeFile
     * @return pdfFile
     */
    GotenbergFile convertOfficeFile(GotenbergFile officeFile);

    GotenbergFile conevertHtmlFile(GotenbergFile officeFile);

    /**
     * Merges multiple PDF Files into one
     * @param pdfFiles
     * @return pdfFile
     */
    GotenbergFile mergePdfFils(GotenbergFile[] pdfFiles);

    /**
     * create  PDF File from Html file
     * @param htmlFile
     * @return pdfFile
     */
    GotenbergFile conevertHtmlFile(GotenbergFile[] htmlFile);


}