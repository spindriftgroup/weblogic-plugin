/**
 * Copyright (C) 2015 Spindrift B.V. All Rights Reserved
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.config.weblogic

class JDBCConnectionPoolParams {
  
  String testTableName='SQL SELECT 1 FROM DUAL'
  def maxCapacity
  
  @Override
  String toString() {
    "  JDBCConnectionPoolParams=[testTableName=${testTableName},maxCapacity=${maxCapacity}]"
  }

}


