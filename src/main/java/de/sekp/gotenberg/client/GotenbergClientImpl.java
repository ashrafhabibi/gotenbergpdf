package de.sekp.gotenberg.client;

import de.sekp.gotenberg.client.dto.GotenbergFile;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

public class GotenbergClientImpl implements GotenbergClient{
    
    private String baseUrl;

    public GotenbergClientImpl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public GotenbergFile convertOfficeFile(GotenbergFile officeFile) {
        return null;
    }

    @Override
    public GotenbergFile conevertHtmlFile(GotenbergFile htmlFile) {

        try {

            var serverUrl = baseUrl + "/forms/chromium/convert/html";
System.out.println("serverURL "+ serverUrl);
            HttpPost post = new HttpPost(serverUrl);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.STRICT);
            builder.setCharset(Charset.defaultCharset());
            builder.setContentType(ContentType.MULTIPART_FORM_DATA);
            builder.addBinaryBody("file", htmlFile.getData(),  ContentType.MULTIPART_FORM_DATA, htmlFile.getName());
            HttpEntity entity = builder.build();
            post.setEntity(entity);
    
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(post);

            var out = new ByteArrayOutputStream();
            System.out.println(response.getEntity());
            response.getEntity().writeTo(out);
            return new GotenbergFile(out.toByteArray(), "out.pdf");
            
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public GotenbergFile mergePdfFils(GotenbergFile[] pdfFiles) {
		return null;
	}

    @Override
    public GotenbergFile conevertHtmlFile(GotenbergFile[] htmlFile) {
        return null;
    }


    
}