package com.jlectra.core.pages;

import javax.persistence.*;

/**
 * User: Nikita Lipatov
 * Date: 7/27/13
 * Time: 10:38 PM
 */
@Entity
@Table(name = "jl_pages")
@NamedQueries({
		@NamedQuery(
				name = "Page.FindByName",
				query = "SELECT jlpage FROM Page jlpage WHERE jlpage.name  LIKE :name"),
		@NamedQuery(
				name = "Page.FindByAlias",
				query = "SELECT jlpage FROM Page jlpage WHERE jlpage.alias LIKE :alias"),
		@NamedQuery(
				name = "Page.FindByTitle",
				query = "SELECT jlpage FROM Page jlpage WHERE jlpage.title LIKE :title"),
		@NamedQuery(
				name = "Page.FindByUrl",
				query = "SELECT jlpage FROM Page jlpage WHERE jlpage.url   LIKE :url")
})
public class Page {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "parent_id")
    private Long parent_id;

    @Column(name = "name")
    private String name;

    @Column(name = "alias")
    private String alias;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
