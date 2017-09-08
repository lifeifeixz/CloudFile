package org.cloud.file.config;

import java.awt.*;

/**
 * Created by flysLi on 2017/8/28.
 */
public enum Action {
    /**
     * Represents an "open" action.
     *
     * @see Desktop#open(java.io.File)
     */
    OPEN,
    /**
     * Represents an "edit" action.
     *
     * @see Desktop#edit(java.io.File)
     */
    EDIT,
    /**
     * Represents a "print" action.
     *
     * @see Desktop#print(java.io.File)
     */
    PRINT,
    /**
     * Represents a "mail" action.
     *
     * @see Desktop#mail()
     * @see Desktop#mail(java.net.URI)
     */
    MAIL,
    /**
     * Represents a "browse" action.
     *
     * @see Desktop#browse(java.net.URI)
     */
    BROWSE
}
