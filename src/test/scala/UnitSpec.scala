// NOTE: Motivated by http://www.scalatest.org/user_guide/defining_base_classes --

package org.dleve123.essentialscala

import org.scalatest._

abstract class UnitSpec extends FunSpec
  with Matchers
  with OptionValues
  with Inside
  with Inspectors
