package template.pageobjects.pages.documentation;

import template.pageobjects.components.Title;
import template.pageobjects.components.documentation.TopNavigationForDocumentation;
import template.pageobjects.pages.website.AbstractBrowsingPage;

public abstract class AbstractDocsBrowsingPage extends AbstractBrowsingPage {

    public Title title = new Title();
    public TopNavigationForDocumentation topNavigationForDocumentation = new TopNavigationForDocumentation();


}
