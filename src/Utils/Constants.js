const constants = {
    title: [
        {
            value: 'mr',
            label: 'Mr',
        },
        {
            value: 'mrs',
            label: 'Mrs',
        },
        {
            value: 'miss',
            label: 'Miss',
        },
        {
            value: 'ms',
            label: 'Ms',
        },
        {
            value: 'dr',
            label: 'Dr',
        }],
    menuItems:
        {
            links: [{
                text: 'Home',
                name: 'home',
                link: '/',
            }, {
                text: 'About us',
                name: 'aboutus',
                link: '/',
                submenu: [{
                    text: 'About us',
                    link: '/AboutUs'
                }, {
                    text: 'What we do',
                    link: '/WhatWeDo'
                }, {
                    text: 'Team',
                    link: '/Team'
                }, {
                    text: 'Pricing',
                    link: '/Pricing'
                }, {
                    text: 'FAQs',
                    link: '/FAQ'
                }]
            }, {
                text: 'Services',
                name: 'services',
                link: '/',
                submenu: [{
                    text: 'Educational Support Services',
                    link: "/EducationSupport"
                }, {
                    text: 'Care Support Services',
                    link: "/CareSupport"
                }, {
                    text: 'Business Support Services',
                    link: "/BusinessSupport"
                }, {
                    text: 'Operations Management',
                    link: "/OperationManagement"
                }, {
                    text: 'Information Tech Services',
                    link: "/InformationTech"
                }]
            }, {
                text: 'Our partners',
                name: 'ourpartners',
                link: '/',
                submenu: [{
                    text: 'Citizens',
                    link: "/Citizen"
                }, {
                    text: 'Small businesses',
                    link: "/SmallBusiness"
                }, {
                    text: 'CCSBI Families',
                    link: "/CCSBIFamilies"
                }, {
                    text: 'Franchises',
                    link: "/Franchises"
                }, {
                    text: 'Other stakeholders',
                    link: "/Stakeholders"
                }]
            }, {
                text: 'Service & Product Search',
                name: 'search',
                link: '/',
                submenu: [{
                    text: 'Service & Product Search',
                    link: "/ServicesProdSearch"
                }, {
                    text: 'Our approach',
                    link: "/OurApproach"
                }, {
                    text: 'Help: How it Works',
                    link: "/Help"
                }, {
                    text: 'Write your need',
                    link: "/WriteToUs"
                }, {
                    text: 'Additional information',
                    link: "/AdditionalInfo"
                }]
            },{
                text: 'Charity Options',
                name: 'charityoptions',
                link: "/CharityOptions"
            }, {
                text: 'Opinion polls',
                name: 'opinionpolls',
                link: "/OpinionPolls"
            }, {
                text: 'Contact us',
                name: 'contactus',
                link: "/ContactUs"
            }
            ]
        },
    rightMenu:
        {
            "1": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "MyOrders", "MyUsageBills", "SecureMessages","WebChatistory", "MyDocument"],
            "2": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "MyOrders", "MyUsageBills", "SecureMessages","WebChatistory", "MyDocument"],
            "3": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "ManageCompany", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "4": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "PaymentDashboard", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "5": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "AdminDashboard", "CommunicationDashboard", "SecureMessages","WebChatHistory", "MyDocument"],
            "6": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "ManageCompany", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "7": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "ManageCompany", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "8": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "ManageCompany", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "9": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "ManageCompany", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "10":["AdminDashboard"]
        }


};
export default constants;