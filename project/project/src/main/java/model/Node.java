package project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Node {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  private String url;
  private String name;
  private String userId;

  public Node() {
    //default constructor
  }

  public Node(final String url, final String name, final String userId) {
    this.url = url;
    this.name = name;
    this.userId = userId;
  }}
