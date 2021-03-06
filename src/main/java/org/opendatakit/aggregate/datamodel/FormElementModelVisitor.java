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
package org.opendatakit.aggregate.datamodel;

import org.opendatakit.common.web.CallingContext;

/**
 * Visitor interface for the {@link FormElementModel#depthFirstTraversal }
 * method.
 *
 * @author mitchellsundt@gmail.com
 */
public interface FormElementModelVisitor {

  boolean traverse(FormElementModel element, CallingContext cc);

  boolean enter(FormElementModel element, CallingContext cc);

  boolean descendIntoRepeat(FormElementModel element, int ordinal, CallingContext cc);

  void ascendFromRepeat(FormElementModel element, int ordinal, CallingContext cc);

  void leave(FormElementModel element, CallingContext cc);
}
