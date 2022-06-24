package com.techreturners

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AppTest extends AnyFlatSpec with Matchers{

  "A Game of Life" should "start with an empty 8x8 grid" in {
    val newPlayer= new Player("abcd")
    val newGame=new GameOfLife((3,3))
    assert(newGame.gridSize==(3,3))

  }

}
