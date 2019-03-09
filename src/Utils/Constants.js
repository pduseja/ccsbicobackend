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
        departments: [
        {
            value: 'Sales Support',
            label: 'Sales Support',
        },
        {
            value: 'Customer Support',
            label: 'Customer Support',
        },
        {
            value: 'Technical Support',
            label: 'Technical Support',
        }],
       subject: [
       {
           value: 'Query',
           label: 'Query',
       },
       {
           value: 'Feedback',
           label: 'Feedback',
       },
       {
           value: 'Complaint',
           label: 'Complaint',
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
            "1": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "MyOrders", "MyUsageBills", "SecureMessages","WebChatHistory", "MyDocument"],
            "2": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "MyOrders", "MyUsageBills", "SecureMessages","WebChatHistory", "MyDocument"],
            "3": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "ManageCompany", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "4": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "PaymentDashboard", "CommunicationDashboard", "SecureMessages","CompletedChat", "MyDocument"],
            "5": ["Profile", "AccessUpdate", "MyDashboard", "LiveChatDashboard", "SupportDashboard", "CommunicationDashboard", "SecureMessages","WebChatHistory", "MyDocument","ClientSupportDashboard","AdminDashboard","Miscellaneous"],
            "6": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "ManageServicesAndProduct", "MyUsageAndBills", "SecureMessages","WebChatHistory", "MyDocument", "CommunicationReport", "FinancialReport", "OtherReports"],
            "7": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "ManageServicesAndProduct", "MyUsageAndBills", "SecureMessages","WebChatHistory", "MyDocument", "CommunicationReport", "FinancialReport", "OtherReports"],
            "8": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "ManageServicesAndProduct", "MyUsageAndBills", "SecureMessages","WebChatHistory", "MyDocument", "CommunicationReport", "FinancialReport", "OtherReports"],
            "9": ["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "ManageServicesAndProduct", "MyUsageAndBills", "SecureMessages","WebChatHistory", "MyDocument", "CommunicationReport", "FinancialReport", "OtherReports"],
            "10":["Profile", "AccessUpdate", "MyDashboard", "CCSBIPay", "MyOrders", "MyUsageBills", "SecureMessages","WebChatHistory", "MyDocument", "CommunicationReport", "FinancialReport", "AdminDashboard"]
        },
        pageMapping:{
            "Profile": "My Profile",
            "AccessUpdate": "Access Update",
            "MyDashboard": "My Dashboard",
            "MyOrders": "My Orders",
            "MyUsageBills": "My Usage Bills",
            "WebChatHistory": "Web Chat History",
            "MyDocument": "My Document",
            "LiveChatDashboard": "Live Chat Dashboard",
            "ManageCompany": "Manage Company",
            "CommunicationDashboard": "Communication Dashboard",
            "SecureMessages": "Secure Messages",
            "CompletedChat": "Completed Chat",
            "PaymentDashboard": "Payment Dashboard",
            "SupportDashboard": "Support Dashboard",
            "CCSBIPay": "CCSBI Pay",
            "ManageServicesAndProduct": "Manage Services And Product",
            "MyUsageAndBills": "MyUsage And Bills",
            "CommunicationReport": "Communication Report",
            "FinancialReport": "Financial Report",
            "OtherReports": "Other Reports",
            "ClientSupportDashboard": "Client Support Dashboard",
            "AdminDashboard": "Admin Dashboard",
            "Miscellaneous": "Miscellaneous"
        },
        profiles:{
            "3": "Sales_Support",
            "2": "Customer_Support",
            "1": "Techical_Support"
        }


};
export default constants;