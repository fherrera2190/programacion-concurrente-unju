package tp5.tp5.punto3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> links = new LinkedList<>();

		String respuesta = obtenerHTML("https://eltribunodejujuy.com/seccion/policiales");
		
		// Expresión regular para buscar href que empiecen con "/nota/"
		Pattern pattern = Pattern.compile("<a\\s+href=\"(/nota/[^\"]*)\"");
		Matcher matcher = pattern.matcher(respuesta);

		// Extraer y mostrar el valor del href
		int j = 1;
		while (matcher.find()) {			
			String textLink =matcher.group(1);
			if(!textLink.equals("/nota/undefined")) {				
				String href = "https://eltribunodejujuy.com" + textLink;
				links.add(href);
				System.out.println("Link nota " + j + ": " + href);
				j++;
			}
		}

		System.out.println("*************************************************");

		int i = 1;
		while (!links.isEmpty()) {
			String link = links.poll();
			Thread hiloTemp = new Thread(new HiloLeerNota(link, i));
			hiloTemp.start();
			i++;
		}
	}

	public static String obtenerNota(String nota) {
		String respuesta = obtenerHTML(nota);
		String regex = "<div\\s+amp-access=\"mostrarNota\"[^>]*>(.*?)</div>\\s*</div>\\s*<div class=\"tags mobile\">";

		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(respuesta);

		if (matcher.find()) {
			String divContent = matcher.group(1);

			String cleanedContent = divContent.replaceAll("<div[^>]*>.*?</div>", "");

			String paragraphRegex = "<p>(.*?)</p>";
			Pattern paragraphPattern = Pattern.compile(paragraphRegex, Pattern.DOTALL);
			Matcher paragraphMatcher = paragraphPattern.matcher(cleanedContent);

			StringBuilder extractedText = new StringBuilder();
			while (paragraphMatcher.find()) {
				extractedText.append(paragraphMatcher.group(1)).append("\n");
			}

			String result = extractedText.toString().trim();
			String noHtmlRegex = "<[^>]*>";
            result = result.replaceAll(noHtmlRegex, "");
            result = decodeHtml(result);
			return result;
		} else {
			
			return "No se encontró la etiqueta <div> con amp-access=\"mostrarNota\"";
		}
	}
	
	private static String decodeHtml(String text) {
		 return text.replaceAll("&amp;", "&")
	               .replaceAll("&lt;", "<")
	               .replaceAll("&gt;", ">")
	               .replaceAll("&quot;", "\"")
	               .replaceAll("&#x27;", "'")
	               .replaceAll("&#xA0;", " ")
	               .replaceAll("&#xE9;", "é") 
	               .replaceAll("&#xED;", "í") 
	               .replaceAll("&#xF3;", "ó")  
	               .replaceAll("&#xE1;", "á") 
	               .replaceAll("&#xE7;", "ç") 
	               .replaceAll("&#xF1;", "ñ") 
	               .replaceAll("&#xFA;", "ú")  
	               .replaceAll("&#x201C;", "“") 
	               .replaceAll("&#x201D;", "”") 
	               .replaceAll("&#x2018;", "‘") 
	               .replaceAll("&#x2019;", "’");
    }

	public static String obtenerHTML(String urlString) {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
