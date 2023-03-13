package adapters;

import com.google.gson.Gson;

public class DefectAdapter extends BaseAdapter{

    private final static String ENDPOINT = "/defect";

    public String createDefect(String projectCode, String requestBody, int statusCode) {
        return post(ENDPOINT + "/" + projectCode, statusCode, requestBody);
    }

    public String deleteDefectByProjectCodeAndDefectId(String projectCode, int defectId, int statusCode) {
        return delete(ENDPOINT + "/" + projectCode + "/" + defectId, statusCode);
    }

    public String getDefectByProjectCodeAndDefectId(String projectCode, int defectId, int statusCode){
        return get(ENDPOINT + "/" + projectCode + "/" + defectId, statusCode);
    }
}
