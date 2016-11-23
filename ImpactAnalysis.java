package com.soti.jira.jira.tabpanels;

import com.atlassian.jira.issue.tabpanels.GenericMessageAction;
import com.atlassian.jira.user.ApplicationUser;
import com.soti.jira.GetStuff.GetStuff;
import com.soti.jira.Parser.Changesets;
import com.soti.jira.Parser.Changeset;
import com.soti.jira.Parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueTabPanel;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel;
import com.atlassian.jira.issue.Issue;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.atlassian.jira.config.properties.APKeys;
import com.atlassian.jira.config.properties.ApplicationProperties;
import com.atlassian.jira.util.VelocityParamFactory;
import com.atlassian.velocity.VelocityManager;
import com.atlassian.jira.component.ComponentAccessor;


public class ImpactAnalysis extends AbstractIssueTabPanel implements IssueTabPanel
{
    private static final Logger log = LoggerFactory.getLogger(ImpactAnalysis.class);

    public List getActions(Issue issue, ApplicationUser remoteUser) {
        ApplicationProperties ap = ComponentAccessor.getApplicationProperties();
        String baseUrl = ap.getString(APKeys.JIRA_BASEURL);
        String webworkEncoding = ap.getString(APKeys.JIRA_WEBWORK_ENCODING);

        VelocityManager vm = ComponentAccessor.getVelocityManager();
        VelocityParamFactory vp = ComponentAccessor.getVelocityParamFactory();

        Map context = vp.getDefaultVelocityParams();
        String json = (new GetStuff()).loginDev(null);
        Parser parser = new Parser();
        Changesets parsed = parser.parseChangesets(json);

        //map to display
        context.put("parsedArray", parsed.value);

        //last check-in information
        context.put("changeset", parsed.value[0].changesetId);
        context.put("checkedInBy", parsed.value[0].checkedInBy.displayName);
        context.put("comment", parsed.value[0].comment);

        String renderedText = vm.getEncodedBody("templates/tabpanels/", "impact-analysis.vm", baseUrl, webworkEncoding, context);
        return Collections.singletonList(new GenericMessageAction(renderedText));
    }

    public boolean showPanel(Issue issue, ApplicationUser remoteUser)
    {
        return true;
    }
}