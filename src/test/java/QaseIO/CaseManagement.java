package QaseIO;

import helper.QaseConfig;
import io.cucumber.java.Status;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static helper.QaseConfig.*;

public class CaseManagement{

    private static final String Qase_Token = "46630c186c333f07d33a51feceb936161cb987cf355dbae7b1aaee03016db416";
    private static final String result_qase_Url = Post_Result_Host_Qase;
    private static final String project_Code = PROJECT_CODE;
    private static final String project_Id = PROJECT_ID;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();
    private int testsFailedBefore;

    @Before
    public void beforeScenario(Scenario scenario) {
        testsFailedBefore = 0;
        System.out.println("before test");
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("after test");
        String testCaseId = scenario.getSourceTagNames().stream()
                .filter(tag -> tag.startsWith("@CaseID"))
                .findFirst()
                .map(tag -> tag.replace("@CaseID=", ""))
                .orElse("Tidak ada Tag yang diterima");

        if (!testCaseId.isEmpty()) {
            String status = scenario.isFailed() ? "failed" : "passed";
            sendResultToQase(testCaseId, status);
        }
    }

    private void sendResultToQase(String caseId, String status) {
        String payload = String.format("{\"case_id\": \"%s\", \"status\": \"%s\"}", caseId, status);
        RequestBody body = RequestBody.create(payload, JSON);
        String endpointUrl = result_qase_Url + PROJECT_CODE + "/" + PROJECT_ID;
        Request request = new Request.Builder()
                .url(endpointUrl)
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("Token", Qase_Token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Result sent to Qase: " + response.body().string());
            } else {
                System.out.println("Failed to send result to Qase: " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
