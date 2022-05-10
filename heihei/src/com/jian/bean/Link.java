package com.jian.bean;


/**
 * 对应数据库的字段
 */
public class Link
{
  private String content;
  private int count;
  private String description;
  private int icon;
  private int id;
  private int sort;
  private String title;
  private int typeId;
  
  public String toString() { return "Link{content='" + this.content + '\'' + ", count=" + this.count + ", description='" + this.description + '\'' + ", icon=" + this.icon + ", id=" + this.id + ", sort=" + this.sort + ", title='" + this.title + '\'' + ", typeId=" + this.typeId + '}'; }

  
  public Link(String content) { this.content = content; }

  
  public Link(String content, int count, String description, int icon, int id, int sort, String title, int typeId) {
    this.content = content;
    this.count = count;
    this.description = description;
    this.icon = icon;
    this.id = id;
    this.sort = sort;
    this.title = title;
    this.typeId = typeId;
  }

  
  public void setContent(String content) { this.content = content; }

  
  public String getContent() { return this.content; }


  
  public void setCount(int count) { this.count = count; }

  
  public int getCount() { return this.count; }


  
  public void setDescription(String description) { this.description = description; }

  
  public String getDescription() { return this.description; }


  
  public void setIcon(int icon) { this.icon = icon; }

  
  public int getIcon() { return this.icon; }


  
  public void setId(int id) { this.id = id; }

  
  public int getId() { return this.id; }


  
  public void setSort(int sort) { this.sort = sort; }

  
  public int getSort() { return this.sort; }


  
  public void setTitle(String title) { this.title = title; }

  
  public String getTitle() { return this.title; }


  
  public void setTypeId(int typeId) { this.typeId = typeId; }

  
  public int getTypeId() { return this.typeId; }
}
