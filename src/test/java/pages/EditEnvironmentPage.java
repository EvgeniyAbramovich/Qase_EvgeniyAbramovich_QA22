package pages;

import elements.DataPlaceHolderDetail;
import elements.InputDetail;
import models.Environment;

public class EditEnvironmentPage extends BasePage{

    public Environment getEnvironmentDetails() {
        Environment.EnvironmentBuilder environment = Environment.builder();

        environment.title(new InputDetail("Title").getInputDetailValue());
        environment.slug(new InputDetail("Slug").getInputDetailValue());
        environment.description(new DataPlaceHolderDetail("Description").getDataPlaceholderDetailValue());
        environment.host(new InputDetail("Host").getInputDetailValue());


        return environment.build();

    }
}
