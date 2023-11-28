package template.pageobjects.pages;

import template.pageobjects.components.Title;

public abstract class AbstractPageObject
{

    public Title title = new Title();

    // public DocsPage docsPage = new DocsPage();

    public void validateStructure()
    {

    }

    public AbstractPageObject isExpectedPage()
    {
        return this;
    }

}
