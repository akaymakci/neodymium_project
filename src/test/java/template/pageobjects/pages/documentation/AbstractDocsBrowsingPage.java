package template.pageobjects.pages.documentation;

import template.pageobjects.components.Title;
import template.pageobjects.components.documentation.TopNavigationForDocs;
import template.pageobjects.pages.website.AbstractBrowsingPage;

public abstract class AbstractDocsBrowsingPage extends AbstractBrowsingPage
{

    public Title title = new Title();

    public TopNavigationForDocs topNavigationForDocs = new TopNavigationForDocs();

    public void validateStructure()
    {
        isExpectedPage();

        topNavigationForDocs.isComponentAvailable();

    }

}
