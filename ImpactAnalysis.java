package com.atlassian.jira.plugins.panel.issue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueTabPanel2;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueAction;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanelModuleDescriptor;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel2;
import com.atlassian.jira.plugin.issuetabpanel.GetActionsRequest;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.tabpanels.GenericMessageAction;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.crowd.embedded.api.User;
import com.atlassian.jira.user.ApplicationUser;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.ArrayList;

public class ImpactAnalysis extends AbstractIssueAction{ 
	private final JiraAuthenticationContext authenticationContext; 
	public ImpactAnalysis(IssueTabPanelModuleDescriptor descriptor, JiraAuthenticationContext authenticationContext) { 
		super(descriptor); this.authenticationContext = authenticationContext; } 
	@Override public Date getTimePerformed() { 
		return new Date(); } 
	@Override protected void populateVelocityParams(Map params) { 
		params.put("user", this.authenticationContext.getUser().getName()); } 


    public List getActions(Issue issue, User remoteUser) {
		List<ImpactAnalysis> panelActions = new ArrayList<ImpactAnalysis>();
		panelActions.add(new ImpactAnalysis(descriptor, authenticationContext));
		return panelActions;
	}

    public boolean showPanel(Issue issue, User remoteUser)
    {
        return true;
    }
}

