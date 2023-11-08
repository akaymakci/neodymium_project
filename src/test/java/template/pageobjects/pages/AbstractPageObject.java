package template.pageobjects.pages;

import template.pageobjects.components.Footer;
import template.pageobjects.components.Title;
import template.pageobjects.components.TopNavigation;

/**
 * @author pfotenhauer
 */
public abstract class AbstractPageObject
{
    public Title title = new Title();

    public TopNavigation topNavigation = new TopNavigation();
    public Footer footer = new Footer();

    public void validateStructure()
    {
        topNavigation.validateStructure();
        footer.validateStructure();

    }

    public AbstractPageObject isExpectedPage() {
        return null;
    }
}
