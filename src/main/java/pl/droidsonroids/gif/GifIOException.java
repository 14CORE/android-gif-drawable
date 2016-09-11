package pl.droidsonroids.gif;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.Locale;

/**
 * Exception encapsulating {@link GifError}s.
 *
 * @author koral--
 */
public class GifIOException extends IOException {
	private static final long serialVersionUID = 13038402904505L;
	/**
	 * Reason which caused an exception
	 */
	@NonNull
	public final GifError reason;

	private GifIOException(@NonNull GifError reason) {
		super(reason.getFormattedDescription());
		this.reason = reason;
	}

	//invoked from native code
	GifIOException(int errorCode, String message) {
		super(String.format(Locale.ENGLISH, "%s %s", GifError.fromCode(errorCode).getFormattedDescription(), message));
		reason = GifError.fromCode(errorCode);
	}
}
