package views.fragments.atoms

import model.content.MediaAssetPlatform.Youtube
import model.content.{MediaAsset, MediaAtom}
import org.scalatestplus.play.MixedPlaySpec
import play.api.test.FakeRequest
import play.api.test.Helpers._

class YoutubeSpec extends MixedPlaySpec {

  "Youtube atom view" should {
    "contain player placeholder div" in new App {
      val mediaAtom = MediaAtom(
        id = "atomId",
        defaultHtml = "",
        assets = Seq(
          MediaAsset(
            id = "assetId",
            version = 0,
            platform = Youtube,
            mimeType = None
          )),
        title = "",
        duration = None,
        source = None,
        posterImage = None,
        endSlatePath = None,
        expired = None,
        activeVersion = None
      )
      val displayCaption = false
      val html           = views.html.fragments.atoms.youtube(mediaAtom, displayCaption)(FakeRequest())
      contentAsString(html) must include("""<div id="player-assetId"></div>""")
    }
  }
}