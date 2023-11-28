package template.pageobjects.pages.website;

import template.pageobjects.components.Title;
import template.pageobjects.components.website.Footer;
import template.pageobjects.components.website.TopNavigation;

/**
 * @author akaymakci
 */
public abstract class AbstractBrowsingPage
{
    public Title title = new Title();

    public TopNavigation topNavigation = new TopNavigation();

    public Footer footer = new Footer();

    public void validateStructure()
    {
        topNavigation.validateStructure();
        footer.validateStructure();

    }

    public AbstractBrowsingPage isExpectedPage()
    {
        return null;
        // return this;
    }
}
