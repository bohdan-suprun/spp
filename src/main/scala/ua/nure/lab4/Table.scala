package ua.nure.lab4

import scala.collection.mutable

/**
  * Class Table implementation. 
  */
class Table {

  private var innerHtml: mutable.MutableList[List[String]] = new mutable.MutableList[List[String]]

  def ||(other: String): Table = {
    // This a new row
    innerHtml += List(other)
    this
  }

  def |(other: String): Table = {
    // This is a new item
    if (innerHtml.isEmpty){
      innerHtml += List()
    }
    val array = innerHtml.get(innerHtml.size - 1).get
    innerHtml.update(innerHtml.size - 1, array ::: List(other))
    this
  }

  override def toString: String = {
    val tableHtml: mutable.StringBuilder = new mutable.StringBuilder("<TABLE>")
    val rowHtml: mutable.StringBuilder = new mutable.StringBuilder()

    for (row <- innerHtml) {
      rowHtml.clear()
      row.foreach(item => rowHtml.append(s"<TD>$item</TD>"))
      if (rowHtml.nonEmpty) {
        tableHtml.append(s"<TR>$rowHtml</TR>")
      }
    }

    tableHtml.append("</TABLE>").toString()
  }
}
