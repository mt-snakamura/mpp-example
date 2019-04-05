package jp.moneytree

/**
 * @author So Nakamura on 2019-Apr-04
 */
data class Era(
  val name: String,
  val nameKanji: String
)

class EraLoader {
  companion object {
    fun loadEras(): List<Era> =
      listOf(
        Era("Meiji", "明治"),
        Era("Taisyo", "大正"),
        Era("Syowa", "昭和"),
        Era("Heisei", "平成")
      )
  }
}




















//Era(
//  "Reiwa",
//  "令和"
//)
