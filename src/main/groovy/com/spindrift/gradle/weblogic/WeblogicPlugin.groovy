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
package com.spindrift.gradle.weblogic

/**
 * Provides OracleWebLogic domain management and configuration
 *
 * @author hallatech
 */

import java.text.MessageFormat;

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

import com.spindrift.gradle.weblogic.tasks.CleanDomain

class WeblogicPlugin implements Plugin<Project> {
  
static final String PLUGIN_EXTENSION_NAME="weblogicPlugin"
static final String CLEAN_DOMAIN_TASK="cleanDomain"

  @Override
  public void apply(Project project) {
    project.extensions."${PLUGIN_EXTENSION_NAME}" = new WeblogicPluginExtension()
    addCleanDomainTask(project)
  }
  
  private void addCleanDomainTask(Project project) {
    project.task(CLEAN_DOMAIN_TASK, type: CleanDomain )
  }
}
