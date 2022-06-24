package com.techreturners
import scala.util.Random

class GameOfLife(gridDimension:(Int,Int)) {

   val gridSize:(Int,Int)=gridDimension
   val initialGrid:Array[Array[String]]= createGrid(gridDimension)
   val possibleStates:List[String]=List("Alive","Dead")
   val random:Random=new Random()
   val firstGrid:Array[Array[String]]=firstStateGrid(initialGrid)
   var currentGridStatus:Array[Array[String]]=firstGrid
   var nextGrid=playGameOfLife(currentGridStatus)

   def playGameOfLife(grid: Array[Array[String]]):Unit ={
     for (i<-1 until gridSize._1;j<-1 until gridSize._2){
       val cell:String=grid(i)(j)
       println(cell)
       val neighbours:List[String]=List(grid(i-1)(j-1),grid(i-1)(j),grid(i-1)(j+1),grid(i)(j-1),grid(i)(j+1),grid(i+1)(j-1),grid(i+1)(j),grid(i+1)(j+1))
       val unique=neighbours.distinct
       println(neighbours.mkString)
       val liveCount:Int=neighbours.count(_=="Alive")
       println(liveCount)
       if (cell=="Alive" && (liveCount==2 ||liveCount==3)){
         grid(i)(j)="Alive"
       }
       else if(cell=="Alive" && (liveCount<2|| liveCount>3)){
         grid(i)(j)="Dead"
       }
       else if(cell=="Dead" && liveCount==3){
         grid(i)(j)="Alive"
       }
       println(grid(i)(j))
     }
     grid
   }


  def firstStateGrid(grid: Array[Array[String]]):Array[Array[String]]= {
    for (i <- 0 until gridSize._1; j <- 0 until gridSize._2) {
      grid(i)(j) = possibleStates(random.nextInt(possibleStates.length))
      println(s"($i)($j)=${grid(i)(j)}")
    }
    grid
  }
  def createGrid(gridSize:(Int,Int)): Array[Array[String]] = {
    val defaultValue = "Blank"
    //var grid: Array[Array[String]] = Array.ofDim[String](gridSize._1,gridSize._2)
     val grid = Array.fill(gridSize._1,gridSize._2)(defaultValue)
     /*for (i <- 0 until gridSize._1; j <- 0 until gridSize._2) {
      println(s"($i)($j)=${grid(i)(j)}")
      }*/
    grid
  }
}
