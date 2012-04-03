/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.codegen.builder.callstack;

import org.jboss.errai.codegen.meta.MetaClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mike Brock <cbrock@redhat.com>
 */
public class CallWriter {
  private StringBuilder buffer;
  private Map<String, MetaClass> typeParmCapture = new HashMap<String, MetaClass>();

  public CallWriter() {
    reset();
  }

  public CallWriter append(String str) {
    buffer.append(str);
    return this;
  }

  public void reset() {
    buffer = new StringBuilder(128);
  }

  public String getCallString() {
    return buffer.toString();
  }

  public void recordTypeParm(String var, MetaClass type) {
    this.typeParmCapture.put(var, type);
  }

  public MetaClass getTypeParm(String var) {
    return typeParmCapture.get(var);

  }
}