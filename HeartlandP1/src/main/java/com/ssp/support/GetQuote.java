package com.ssp.support;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetQuote {

	private static String quoteId = "3d4ef666-19b0-4406-937b-d5252f99a190";
	private static String token = "eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0.eyJzdWIiOiJEODdCMDMyNC1DRTZCLTQ1MjUtQUMxMy01MjU5NzEwQjI2OTAiLCJjdXN0b206dGVuYW50Q29kZSI6IlNTUCIsImN1c3RvbTp0ZW5hbnRJZCI6IkIyNDQxQzA0LTNBODItNDA3OS04Mjc3LTlCREE1RUY2MEVBNCIsImNvZ25pdG86dXNlcm5hbWUiOiJBZG1pbkBjb2duaXRvLmNvbSIsInJvbGUiOiJBZG1pbiIsIm5iZiI6MTUzNzE2NzczOCwiZXhwIjoxNTM5NzU5NzM4LCJpYXQiOjE1MzcxNjc3MzgsImlzcyI6IkNvZ25pdG8ifQ.";

	// private String password = "";*/
	// public static void main(String[] args) throws IOException {

	// JsonObject quoteResult = getQuoteResults();
	// System.out.println(quoteResult);
	/*
	 * String lineOfBusiness =
	 * quoteResult.getAsJsonObject("quoteResponseList").get("lineOfBusiness").
	 * getAsString(); System.out.println("Line Of Business" + "=" +
	 * lineOfBusiness); JsonArray array =
	 * quoteResult.getAsJsonObject("quoteResponseList").getAsJsonArray(
	 * "acceptedResponses"); for (JsonElement jsonElement : array) {
	 * System.out.println(
	 * jsonElement.getAsJsonObject().getAsJsonObject("acceptedResponse").get(
	 * "responseId").getAsString()); }
	 */

	/*
	 * HashMap<String, String> ResponseData = new HashMap<String, String>();
	 * ResponseData.put("LIneofbusiness", lineOfBusiness);
	 */

	// }

	public static HashMap<String, String> getQuoteResults() throws Exception {

		try {
			String url = "http://in00265:5001/quotes/" + quoteId + "/responses";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization", "bearer " + token);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				con.disconnect();
				String res = response.toString();

				System.out.println(res);

				JsonObject json = (JsonObject) new JsonParser().parse(res);
				String lineOfBusiness = json.getAsJsonObject("quoteResponseList").get("lineOfBusiness").getAsString();
				String coverStartDate = json.getAsJsonObject("quoteResponseList").get("coverStartDate").getAsString();

				HashMap<String, String> QuoteResultAPIValues = new HashMap<String, String>();
				QuoteResultAPIValues.put("lineOfBusiness", lineOfBusiness);
				QuoteResultAPIValues.put("coverStartDate", coverStartDate);
				// return json;
				return QuoteResultAPIValues;
			}
			return null;
		} catch (NoSuchElementException e) {
			// Log.fail("Fail to achieve expected result : " + errorMessage,
			// driver, extentedReport, true);
			throw new Exception("No Element Found to assert" + e);
		}
	}

}
