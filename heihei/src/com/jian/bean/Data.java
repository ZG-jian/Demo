package com.jian.bean;

import java.util.List;

public class Data
{
  private List<Link> links;
  private String type;
  
  public String toString() { return "Data{links=" + this.links + ", type='" + this.type + '\'' + '}'; }

  
  public void setLinks(List<Link> links) { this.links = links; }

  
  public List<Link> getLinks() { return this.links; }


  
  public void setType(String type) { this.type = type; }

  
  public String getType() { return this.type; }
}
