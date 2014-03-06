/***
 * ParcelableUtil is a class used to help convert data that
 * can be stored in a file
 * 
 * Jessica Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableUtil {
	
	// converts from parcel and returns array of bytes
    public static byte[] marshall(Parcelable parceable) {
        Parcel parcel = Parcel.obtain();
        parceable.writeToParcel(parcel, 0);
        byte[] bytes = parcel.marshall();
        parcel.recycle(); 
        return bytes;
    }

    // converts given bytes into Parcel
    public static Parcel unmarshall(byte[] bytes) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(bytes, 0, bytes.length);
        parcel.setDataPosition(0);
        return parcel;
    }

}