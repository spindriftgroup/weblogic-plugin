/**
 * Copyright 2015 Spindrift
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.weblogic.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.GradleException

class CleanDomain extends DefaultTask {
  
  static final String TASK_DESCRIPTION = "Cleans (deletes) a WebLogic domain."
  static final String TASK_GROUP = "WebLogic"
  
  CleanDomain() {
    description = TASK_DESCRIPTION
    group = TASK_GROUP
  }
  
  @TaskAction
  public void deleteExistingDomain() {
    println "Cleaning domain ..."
  }

}