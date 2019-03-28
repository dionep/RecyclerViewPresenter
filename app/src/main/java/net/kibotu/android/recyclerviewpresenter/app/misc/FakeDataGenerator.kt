package net.kibotu.android.recyclerviewpresenter.app.misc

import com.exozet.android.core.utils.MathExtensions
import java.text.MessageFormat.format
import java.util.*

/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */
internal object FakeDataGenerator {

    fun createRandomImageUrl(): String {
        val random = Random()
        val landscape = random.nextBoolean()
        val endpoint = random.nextBoolean()

        val width = MathExtensions.random(300, 400)
        val height = MathExtensions.random(200, 300)

        return format(
            if (endpoint)
                "https://lorempixel.com/{0}/{1}/"
            else
                "https://picsum.photos/{0}/{1}/",
            if (landscape) width else height, if (landscape) height else width
        )
    }
}
