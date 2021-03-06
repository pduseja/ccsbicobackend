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
    question: [
        {
            value: 1,
            label: "What is your mother's maiden name?"
        },
        {
            value: 2,
            label: "What is your childhood School name?"
        },
        {
            value: 3,
            label: "Which place you like visiting again & again?"
        },
        {
            value: 4,
            label: "Who is your best friend?"
        },
        {
            value: 5,
            label: "What is your pet name?"
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
            items: {
                text: 'Menu Details'
            }
        }


};
export default constants;