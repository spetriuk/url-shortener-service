package com.example.urlshortenerservicereactive.util;

import io.seruco.encoding.base62.Base62;
import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class HashingUtil {

  public static String hash(String input) {
    var md5Hash = DigestUtils.md5Hex(input);

    var base62Encoder = Base62.createInstance();
    byte[] base62EncodedResult = base62Encoder.encode(md5Hash.getBytes());

    return StringUtils.substring(new String(base62EncodedResult), 0, 7);
  }

}
