/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.application.authenticator.samlsso.logout.context;

import java.util.Map;
import org.mockito.Mock;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.wso2.carbon.identity.application.authenticator.samlsso.TestConstants.INBOUND_SESSION_INDEX;
import static org.wso2.carbon.identity.application.authenticator.samlsso.TestConstants.SUPER_TENANT_DOMAIN;
import static org.wso2.carbon.identity.application.authenticator.samlsso.TestConstants.HTTP_POST_PARAM_SAML2_RESP;

import org.wso2.carbon.identity.application.authenticator.samlsso.logout.request.SAMLLogoutRequest;
import org.wso2.carbon.identity.application.common.model.IdentityProvider;

/**
 * Unit test cases for  SAMLMessageContext
 */
public class SAMLMessageContextTest extends PowerMockTestCase {

    @Mock
    private SAMLLogoutRequest mockedRequest;

    @Mock
    private Map<String, String> mockedMap;

    @Mock
    private IdentityProvider mockedIdP;

    @Test
    public void test() {

        SAMLMessageContext context = new SAMLMessageContext(mockedRequest, mockedMap);
        context.setSessionID(INBOUND_SESSION_INDEX);
        context.setTenantDomain(SUPER_TENANT_DOMAIN);
        context.setValidStatus(true);
        context.setFederatedIdP(mockedIdP);
        context.setResponse(HTTP_POST_PARAM_SAML2_RESP);

        assertEquals(INBOUND_SESSION_INDEX, context.getSessionID(), "Failed to handle for valid input");
        assertEquals(SUPER_TENANT_DOMAIN, context.getTenantDomain(), "Failed to handle for valid input");
        assertTrue(context.getValidStatus(), "Failed to handle for valid input");
        assertEquals(mockedIdP, context.getFederatedIdP(), "Failed to handle for valid input");
        assertEquals(HTTP_POST_PARAM_SAML2_RESP, context.getResponse(), "Failed to handle for valid input");
    }
}
