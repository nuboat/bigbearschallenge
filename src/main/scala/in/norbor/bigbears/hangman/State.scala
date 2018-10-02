package in.norbor.bigbears.hangman

import in.norbor.bigbears.hangman.Status.Status


/**
  * status: enum(‘in-progress’, ‘win’, ‘lose’) สถานะของเกม
  * selectedLetters: char[] ชุดตัวอักษรที่ผู้เล่นเลือกมาก่อนหน้า
  * lifeLeft: number จำนวนชีวิตที่เหลือ (จำนวนครั้งที่ผิดได้)
  * secretWordLength: number จำนวนความยาวตัวอักษรทั้งหมดของคำลับ
  * knownSecretWord: string คำลับและตัวอักษรที่ทราบคำตอบแล้วพร้อมระบุตำแหน่ง ส่วนตำ่แหน่งที่ยังไม่ทราบให้ใช้ _ แทนค่า
  *
  * @author Peerapat A on Oct 1, 2018
  */
case class State(selected: List[Char]
                 , status: Status
                 , lifeLeft: Int) {

  def knownSecret: String = selected.mkString("")

  def correct(update: List[Char]): State = if (update.contains('_'))
    this.copy(selected = update)
  else
    this.copy(status = Status.Win, selected = update)
}

object State {

  def apply(word: String): State = State(
    status = Status.InGame
    , selected = word.map(_ => '_').toList
    , lifeLeft = 7)

}
