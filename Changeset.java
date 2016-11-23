package com.soti.jira.Parser;

/**
 * Created by dister on 11/9/2016.
 */
public class Changeset {
    public int changesetId;
    public String url;
    public Author author;
    public CheckedInBy checkedInBy;
    public String createdDate;
    public String comment;
    public Links _links;

    //Velocity forces users to use getters.
    public int getChangesetId() {
        return changesetId;
    }

    public CheckedInBy getCheckedInBy() {
        return checkedInBy;
    }

    public String getComment() {
        return comment;
    }

    class Author {
        public String id;
        public String displayName;
        public String uniqueName;
        public String url;
        public String imageUrl;
    }

     public class CheckedInBy {
        public String id;

         public String getDisplayName() {
             return displayName;
         }

         public String displayName;
        public String uniqueName;
        public String url;
        public String imageUrl;
    }

    public class Links {
        public LinkObject self;
        public LinkObject changes;
        public LinkObject workItems;
        public LinkObject web;
        public LinkObject author;
        public LinkObject checkedInBy;
    }

    class LinkObject {
        public String href;
    }
}
