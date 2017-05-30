package com.iostate.bms.entity

import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.*

@MappedSuperclass
abstract class BaseModel : Serializable{

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = 0

  @Version
  var version: Long = 0

  var whenCreated: Timestamp? = null

  var whenModified: Timestamp? = null

}
