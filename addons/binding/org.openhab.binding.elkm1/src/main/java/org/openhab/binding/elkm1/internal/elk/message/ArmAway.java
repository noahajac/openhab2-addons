/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.elkm1.internal.elk.message;

import org.openhab.binding.elkm1.internal.elk.ElkCommand;
import org.openhab.binding.elkm1.internal.elk.ElkMessage;
import org.openhab.binding.elkm1.internal.elk.ElkMessageFactory;

/**
 * The arm away class, to put the elk into armed away mode.
 *
 * @author David Bennett - Initial Contribution
 *
 */
public class ArmAway extends ElkMessage {
    private final int area;
    private final String pincode;

    public ArmAway(int area, String pincode) {
        super(ElkCommand.ArmAway);
        this.area = area;
        if (area > ElkMessageFactory.MAX_AREAS) {
            area = ElkMessageFactory.MAX_AREAS;
        }
        if (area < 0) {
            area = 0;
        }
        if (pincode.length() == 4) {
            pincode = "00" + pincode;
        }
        System.out.println(pincode);
        this.pincode = pincode;
    }

    @Override
    public String getData() {
        return area + pincode;
    }
}
