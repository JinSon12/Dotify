package com.example.dotify

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.dotify.model.Song
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class NavGraphDirections private constructor() {
  private data class ActionGlobalStatisticsFragment(
    public val song: Song
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_global_statisticsFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  public companion object {
    public fun actionGlobalStatisticsFragment(song: Song): NavDirections =
        ActionGlobalStatisticsFragment(song)
  }
}
