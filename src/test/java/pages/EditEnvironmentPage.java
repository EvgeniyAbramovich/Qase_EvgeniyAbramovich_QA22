package pages;

import elements.EditDetail;
import models.Environment;

public class EditEnvironmentPage extends BasePage{

    public Environment getEnvironmentDetails() {
        Environment.EnvironmentBuilder environment = Environment.builder();

        environment.title(new EditDetail("Title").getInputDetailValue());
        environment.slug(new EditDetail("Slug").getInputDetailValue());
        environment.description(new EditDetail("Description").getDataPlaceholderDetailValue());
        environment.host(new EditDetail("Host").getInputDetailValue());


        return environment.build();

    }
}
