package com.example.dotify.fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.dotify.model.Song
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class StatisticsFragmentArgs(
  public val song: Song
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Song::class.java)) {
      result.putParcelable("song", this.song as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Song::class.java)) {
      result.putSerializable("song", this.song as Serializable)
    } else {
      throw UnsupportedOperationException(Song::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): StatisticsFragmentArgs {
      bundle.setClassLoader(StatisticsFragmentArgs::class.java.classLoader)
      val __song : Song?
      if (bundle.containsKey("song")) {
        if (Parcelable::class.java.isAssignableFrom(Song::class.java) ||
            Serializable::class.java.isAssignableFrom(Song::class.java)) {
          __song = bundle.get("song") as Song?
        } else {
          throw UnsupportedOperationException(Song::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__song == null) {
          throw IllegalArgumentException("Argument \"song\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"song\" is missing and does not have an android:defaultValue")
      }
      return StatisticsFragmentArgs(__song)
    }
  }
}
