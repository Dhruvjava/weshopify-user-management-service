package com.cb.util;

import com.cb.Messages;
import com.cb.base.rs.ErrorRs;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Utils {

    public static boolean isEmpty(List list) {
        return null == list || list.isEmpty();
    }

    public static boolean isEmpty(String string) {
        return null == string || string.trim().isEmpty();
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static ErrorRs populateErrorRSs(String codes, Messages message) {
        if (log.isDebugEnabled()) {
            log.debug("Executing populateErrorRs(List<String>) -> ");
        }
        try {
            if (isEmpty(codes)) {
                return null;
            }
            ErrorRs error = new ErrorRs();
            error.setCode(codes);
            error.setMessage(message.getErrorProperty(codes));
            return error;
        } catch (Exception e) {
            log.error("Exception in populateErrorRs(List<String>) -> {0}", e);
            return null;
        }
    }

}