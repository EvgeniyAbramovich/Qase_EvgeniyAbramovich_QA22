package adapters;

public class ProjectAdapter extends BaseAdapter{

    private static final String ENDPOINT = "/project";

    public String getAllProjects(int statusCode){
        return get(ENDPOINT, statusCode);
    }

    public String createProject(int statusCode, String requestBody){
        return post(ENDPOINT, statusCode, requestBody);
    }


    public String deleteProjectByCode(int statusCode, String projectCode){

        return delete(ENDPOINT, statusCode);
    }



}
