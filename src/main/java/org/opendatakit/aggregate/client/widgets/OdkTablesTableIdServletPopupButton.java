/*
 * Copyright (C) 2011 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opendatakit.aggregate.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import org.opendatakit.aggregate.client.AggregateSubTabBase;
import org.opendatakit.aggregate.client.popups.ViewServletPopup;

public final class OdkTablesTableIdServletPopupButton extends AggregateButton implements ClickHandler {

  private final String url;

  ;
  private final String title;
  private final AggregateSubTabBase basePanel;
  private final OdkTablesData dataAccess;
  public OdkTablesTableIdServletPopupButton(String buttonText, String title, String url,
                                            String tooltipText, String balloonText, AggregateSubTabBase basePanel, OdkTablesData dataAccess) {
    super(buttonText, tooltipText, balloonText);
    this.title = title;
    this.url = url;
    this.basePanel = basePanel;
    this.dataAccess = dataAccess;
  }

  @Override
  public void onClick(ClickEvent event) {
    super.onClick(event);

    String tableId = dataAccess.getTableId();
    if (tableId == null) {
      return;
    }
    ViewServletPopup servletPopup = new ViewServletPopup(title,
        url + "?table_id=" + tableId);
    servletPopup.setPopupPositionAndShow(servletPopup.getPositionCallBack());
    servletPopup.addCloseHandler(new CloseHandler<PopupPanel>() {

      @Override
      public void onClose(CloseEvent<PopupPanel> event) {
        if (basePanel != null) {
          basePanel.update();
        }
      }

    });
  }

  public interface OdkTablesData {
    String getTableId();
  }
}